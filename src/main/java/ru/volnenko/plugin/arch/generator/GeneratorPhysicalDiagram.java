package ru.volnenko.plugin.arch.generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.codehaus.plexus.util.FileUtils;
import ru.volnenko.plugin.arch.builder.MxFileNew;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.mx.*;
import ru.volnenko.plugin.arch.mxfile.*;
import ru.volnenko.plugin.arch.util.FileUtil;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class GeneratorPhysicalDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorPhysicalDiagram create() {
        return new GeneratorPhysicalDiagram();
    }

    @Override
    public boolean rewrite() {
        return true;
    }

    private XmlMapper xmlMapper = new XmlMapper();

    @NonNull
    @Override
    public String generate() {
        @NonNull final File file = new File(filename);
        MxFile mxFile = null;
        if (file.exists()) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(filename));
                String xml = new String(bytes);
                mxFile = xmlMapper.readValue(xml, MxFile.class);
            } catch (IOException e) {
                throw new RuntimeException("Error! Parse physical diagram...");
            }
        }
        if (mxFile == null) mxFile = MxFileNew.build();

        if (root() != null) {
            @NonNull final File path = new File(file.getParent());
            for (final User user : root().users()) {
                mxFile.merge(user, path);
            }
            for (final Service item : root().services()) {
                mxFile.merge(item, path);
            }
            for (final ru.volnenko.plugin.arch.model.impl.Database item : root().databases()) {
                mxFile.merge(item, path);
            }
            for (final ru.volnenko.plugin.arch.model.impl.Balancer item : root().balancers()) {
                mxFile.merge(item, path);
            }
            for (final ru.volnenko.plugin.arch.model.impl.System item: root().systems()) {
                mxFile.merge(item, path);
            }
            for (final ru.volnenko.plugin.arch.model.impl.Queue item: root().queues()) {
                mxFile.merge(item, path);
            }
            for (final Environment environment: root().environments()) {
            }
        }

        return FileUtil.formatXml(mxFile.toString());
    }

    @SneakyThrows
    public static void main(String[] args) throws JAXBException {
        final XmlMapper mapper = new XmlMapper();
        final File file = new File("physical-view.drawio");
        MxFile mxFile = mapper.readValue(file, MxFile.class);
    }

    @SneakyThrows
    public void execute() {
        if (!enabled) return;
        @NonNull final File file = new File(filename);
        @NonNull final String parent = file.getParent();
        @NonNull final File path = new File(parent);
        path.mkdirs();
        FileUtils.fileWrite(file, generate());
    }

}
