package ru.volnenko.plugin.arch;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import ru.volnenko.plugin.arch.model.PomDto;
import ru.volnenko.plugin.arch.util.MapperUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


@Mojo(name = "dependency")
public final class Dependency extends AbstractGenerator {

    final String[] component = {"ArchApi", "Balancer", "Database", "Environment", "System", "Queue", "Service", "User"};

    final List<String> components = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    Map<String, String> commands = new LinkedHashMap<>();

    Map<String, PomDto> lastResult = new LinkedHashMap<>();

    @Getter
    @Setter
    @Parameter(property = "archapiUrl", defaultValue = "http://localhost:8080")
    public String archapiUrl = "http://localhost:8080";

    private boolean authRefresh = false;

    {
        components.addAll(Arrays.asList(component));
        components.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        @NonNull Integer index = 1;
        for (@NonNull final String value: components) {
            commands.put(index.toString(), value);
            index++;
        }
    }

    private void menuWelcome() {
        while (true) {
            System.out.println();
            System.out.println("Auto refresh ArchDoc on change?");
            System.out.println();

            System.out.println("1. Enabled");
            System.out.println("2. Disabled");

            System.out.println();
            String cmd = scanner.nextLine();
            if ("".equals(cmd)) System.exit(0);

            authRefresh = "1".equals(cmd);
            if ("gen".equals(cmd)) generate();
            break;
        }
        menuComponent();
    }

    private void menuComponent() {
        System.out.println();
        System.out.println("Select component: ");
        System.out.println();
        while (true) {
            for (String key : commands.keySet()) {
                final String value = commands.get(key);
                System.out.println(key + ". " + value);
            }
            System.out.println();
            String cmd = scanner.nextLine();
            if ("".equals(cmd)) System.exit(0);
            System.out.println();

            final String type = commands.get(cmd);
            if (type.isEmpty()) continue;
            System.out.println();

            while (true) {
                System.out.println(type + " Search...");
                cmd = scanner.nextLine();
                if ("".equals(cmd)) break;
                System.out.println();

                final String link = archapiUrl + "/api/" + type + "/search/all";

                try {
                    URI uri = new URIBuilder(link)
                            .setParameter("search", cmd)
                            .setParameter("minScore", "0.7")
                            .setParameter("limit", "5")
                            .build();
                    final HttpGet httpGet = new HttpGet(uri);

                    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                            String responseBody = EntityUtils.toString(response.getEntity());

                            PomDto[] pomDtos = MapperUtil.json().readValue(responseBody, PomDto[].class);
                            lastResult.clear();

                            Integer index = 1;
                            for (PomDto pomDto: pomDtos) {
                                lastResult.put(index.toString(), pomDto);
                                System.out.println(index + ". " + pomDto.getGroupId() + ":" + pomDto.getArtifactId());
                                System.out.println("   " + pomDto.getName() + " " + pomDto.getDescription());
                                System.out.println();
                                index++;
                            }

                            if (lastResult.isEmpty()) continue;
                            System.out.println("Select " + type + "...");

                            while (true) {
                                String selected = scanner.nextLine();
                                if ("".equals(selected)) break;

                                PomDto pomDto = lastResult.get(selected);
                                if (pomDto == null) continue;

                                System.out.println("Added " + pomDto.getGroupId() + ":" +pomDto.getArtifactId());

                                File pomFile = new File("pom.xml"); // Path to target pom.xml

                                try {
                                    // 1. Read and parse the existing POM file
                                    final MavenXpp3Reader reader = new MavenXpp3Reader();
                                    final Model model = reader.read(new FileReader(pomFile));

                                    // 2. Define the new dependency details
                                    final org.apache.maven.model.Dependency dependency = new org.apache.maven.model.Dependency();
                                    dependency.setGroupId(pomDto.getGroupId());
                                    dependency.setType(pomDto.getType());
                                    dependency.setVersion(pomDto.getVersion());
                                    dependency.setArtifactId(pomDto.getArtifactId());

                                    // 3. Add the dependency to the Maven Model object
                                    model.addDependency(dependency);

                                    // 4. Save and write the updated Model back to disk
                                    final MavenXpp3Writer writer = new MavenXpp3Writer();
                                    try (FileWriter fileWriter = new FileWriter(pomFile)) {
                                        writer.write(fileWriter, model);
                                    }

                                    System.out.println("Dependency added and pom.xml saved successfully!");
                                    if (authRefresh) {
                                        System.out.println("Generate start...");
                                        generate();
                                        System.out.println("Generate finish...");
                                    }

                                } catch (Exception e) {
                                    System.out.println("Error! " + e.getMessage());
                                    System.err.println("Error processing the POM file: " + e.getMessage());
                                }

                                System.out.println();
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("Error! " + e.getMessage());
                        }
                    } catch (IOException e) {
                        System.out.println("Error! " + e.getMessage());
                    }

                } catch (URISyntaxException e) {
                    System.out.println("Error! " + e.getMessage());
                }
            }

        }
    }

    public void execute() throws MojoExecutionException, MojoFailureException {
        menuWelcome();
    }

}
