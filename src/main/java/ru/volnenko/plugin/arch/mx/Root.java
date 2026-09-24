package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.*;
import net.sourceforge.plantuml.FileUtils;
import org.codehaus.plexus.util.Base64;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;
import ru.volnenko.plugin.arch.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    @JsonIgnore
    private List<MxCell> mxCells = new ArrayList<>();

    @JsonIgnore
    private List<UserObject> userObjects = new ArrayList<>();

    @JsonIgnore
    private List<CustomObject> objects = new ArrayList<>();

    @NonNull
    public Root add(@NonNull final MxCell mxCell) {
        mxCells.add(mxCell);
        return this;
    }

    @JsonIgnore
    private XmlMapper objectMapper = new XmlMapper();

    @SneakyThrows
    public MxCell mergeMxCell(@NonNull final MavenProjectDto dto, @NonNull File path) {
        System.out.println("MERGE: "+dto);
        MxCell mxCell = findMxCell(dto);
        if (mxCell == null) {
            mxCell = create(dto);
            mxCells.add(mxCell);
        }

        String file = path.getAbsolutePath() + "/logical-view/" + dto.getUrl() + ".svg";
        final File svg = new File(file);
        if (svg.exists()) {
            SvgFile svgFile = objectMapper.readValue(svg, SvgFile.class);
            mxCell.getMxGeometry().setWidth(svgFile.getWidth().replace("px", ""));
            mxCell.getMxGeometry().setHeight(svgFile.getHeight().replace("px", ""));

            mxCell.setStyle("shape=image;imageAspect=0;aspect=fixed;verticalLabelPosition=bottom;verticalAlign=top;image=data:image/svg+xml," + encodeFileToBase64Binary(file));
            System.out.println(file);
        } else {
            mxCell.setStyle("");
        }

        mxCell.setVersion(dto.getVersion());

        return mxCell;
    }

    @SneakyThrows
    private static String encodeFileToBase64Binary(String fileName) {
        byte[] encoded = Base64.encodeBase64(Files.readAllBytes(Paths.get(fileName)));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    @NonNull
    public MxCell create(@NonNull final MavenProjectDto dto) {
        @NonNull final MxCell mxCell = new MxCell();
        mxCell.setId(dto.getGroupId()+":"+dto.artifactId()+":"+dto.getPackaging());
        mxCell.setArchapi("1.0.0");
        mxCell.setGroupId(dto.getGroupId());
        mxCell.setArtifactId(dto.getArtifactId());
        mxCell.setPackaging(dto.getPackaging());
        mxCell.setVersion(dto.getVersion());
        mxCell.setParent("1");
        mxCell.setVertex("1");
        mxCell.setValue("");

        @NonNull final MxGeometry mxGeometry = new MxGeometry();
        mxGeometry.setX("220");
        mxGeometry.setY("450");
        mxGeometry.setHeight("43");
        mxGeometry.setWidth("168");
        mxGeometry.setAs("geometry");

        mxCell.setMxGeometry(mxGeometry);
        return mxCell;
    }

    public MxCell findMxCell(@NonNull final MavenProjectDto dto) {
        return mxCells.stream().filter(mxCell -> {
            final boolean artifactId = dto.artifactId().equals(mxCell.getArtifactId());
            final boolean groupId = dto.getGroupId().equals(mxCell.getGroupId());
            final boolean packaging = dto.getPackaging().equals(mxCell.getPackaging());
            return artifactId && groupId && packaging;
        }).findAny().orElse(null);
    }

    public boolean containsMxCell(@NonNull final MavenProjectDto dto) {
        return mxCells.stream().anyMatch(mxCell -> {
            final boolean artifactId = dto.artifactId().equals(mxCell.getArtifactId());
            final boolean groupId = dto.getGroupId().equals(mxCell.getGroupId());
            final boolean packaging = dto.getPackaging().equals(mxCell.getPackaging());
            return artifactId && groupId && packaging;
        });
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<root>").append("\n");
        if (mxCells != null) for (final MxCell cell: mxCells) stringBuilder.append(cell);
        if (userObjects != null) for (final UserObject o: userObjects) stringBuilder.append(o);
        if (objects !=null) for (final CustomObject o: objects) stringBuilder.append(o);
        stringBuilder.append("</root>").append("\n");
        return stringBuilder.toString();
    }

    @JsonSetter(value =  "mxCell")
    public void setMxCellXml(MxCell mxCell) {
        if (this.mxCells == null) {
            this.mxCells = new ArrayList<>();
        }
        this.mxCells.add(mxCell);
    }

    @JsonSetter(value =  "object")
    public void setObjectXml(CustomObject object) {
        if (this.objects == null) {
            this.objects = new ArrayList<>();
        }
        this.objects.add(object);
    }

    @JsonSetter(value =  "userObject")
    public void setUserObjectXml(UserObject object) {
        if (this.userObjects == null) {
            this.userObjects = new ArrayList<>();
        }
        this.userObjects.add(object);
    }

    @NonNull
    public Root mxCell(MxCell mxCell) {
        mxCells.add(mxCell);
        return this;
    }

}
