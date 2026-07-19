package ru.volnenko.plugin.arch.component;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.maven.project.MavenProject;
import ru.volnenko.plugin.arch.util.MapperUtil;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class PomDeployer {

    @NonNull
    public static PomDeployer create() {
        return new PomDeployer();
    }

    @NonNull
    private String archapiUrl = "http://localhost:8080";

    @NonNull
    private Boolean archapiEnabled = false;

    private MavenProject mavenProject;

    @NonNull
    public PomDeployer mavenProject(@NonNull final MavenProject mavenProject) {
        this.mavenProject = mavenProject;
        return this;
    }

    @NonNull
    public PomDeployer archapiEnabled(@NonNull final Boolean archapiEnabled) {
        this.archapiEnabled = archapiEnabled;
        return this;
    }

    @NonNull
    public PomDeployer archapiUrl(@NonNull final String archapiUrl) {
        this.archapiUrl = archapiUrl;
        return this;
    }

    @SneakyThrows
    public void execute() {
        if (!archapiEnabled) return;
        @NonNull final String groupId = StringUtil.format(mavenProject.getGroupId());
        @NonNull final String artifactId =  StringUtil.format(mavenProject.getArtifactId());
        @NonNull final String version =  StringUtil.format(mavenProject.getVersion());
        @NonNull final String type =  StringUtil.format(mavenProject.getPackaging());

        @NonNull final String name =  StringUtil.format(mavenProject.getName());
        @NonNull final String description =  StringUtil.format(mavenProject.getDescription());
        @NonNull final String url =  StringUtil.format(mavenProject.getUrl());

        @NonNull final Map<String, String> pomDto = new LinkedHashMap<>();
        pomDto.put("groupId", groupId);
        pomDto.put("artifactId", artifactId);
        pomDto.put("version", version);
        pomDto.put("type", type);
        pomDto.put("name", name);
        pomDto.put("description", description);
        pomDto.put("url", url);

        final String link = archapiUrl + "/api/" + type + "/one";
        System.out.println(link);
        @NonNull final HttpPost httpPost = new HttpPost(link);
        @NonNull final String jsonPayload = MapperUtil.json().writeValueAsString(pomDto);

        System.out.println(jsonPayload);
        @NonNull final StringEntity entity = new StringEntity(jsonPayload, ContentType.APPLICATION_JSON);

        httpPost.setEntity(entity);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpPost)) {
            System.out.println("Response Code: " + response.getCode());
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                System.out.println("Response Body: " + EntityUtils.toString(responseEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
