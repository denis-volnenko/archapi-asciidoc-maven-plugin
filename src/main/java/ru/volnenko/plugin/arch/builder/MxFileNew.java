package ru.volnenko.plugin.arch.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.mx.Diagram;
import ru.volnenko.plugin.arch.mx.MxCell;
import ru.volnenko.plugin.arch.mx.MxFile;
import ru.volnenko.plugin.arch.mx.MxGraphModel;
import ru.volnenko.plugin.arch.mx.Root;

public final class MxFileNew {

    @NonNull
    public static MxFile build() {
        @NonNull final MxFile mxFile = mxFile();
        @NonNull final Diagram diagram = diagram();
        mxFile.diagram(diagram);
        @NonNull final MxGraphModel mxGraphModel = mxGraphModel();
        diagram.setMxGraphModel(mxGraphModel);
        @NonNull final Root root = new Root();
        mxGraphModel.setRoot(root);
        @NonNull final MxCell mxCell0 = mxCell0();
        @NonNull final MxCell mxCell1 = mxCell1();
        root.mxCell(mxCell0).mxCell(mxCell1);
        return mxFile;
    }

    @NonNull
    private static MxFile mxFile() {
        @NonNull final MxFile mxFile = new MxFile();
        mxFile.setHost("drawio-plugin");
        mxFile.setModified("2026-09-24T06:54:14.262Z");
        mxFile.setAgent("Mozilla");
        mxFile.setEtag("BRWCp266IsyFUOcJYXh5");
        mxFile.setVersion("22.1.22");
        mxFile.setType("embed");
        return mxFile;
    }

    @NonNull
    private static Diagram diagram() {
        @NonNull final Diagram diagram = new Diagram();
        diagram.setId("view");
        diagram.setName("view");
        return diagram;
    }

    @NonNull
    private static MxCell mxCell0() {
        @NonNull final MxCell mxCell = new MxCell();
        mxCell.setId("0");
        return mxCell;
    }

    @NonNull
    private static MxCell mxCell1() {
        @NonNull final MxCell mxCell = new MxCell();
        mxCell.setId("1");
        mxCell.setParent("0");
        return mxCell;
    }

    @NonNull
    private static MxGraphModel mxGraphModel() {
        @NonNull final MxGraphModel mxGraphModel = new MxGraphModel();
        mxGraphModel.setDx("433");
        mxGraphModel.setDy("565");
        mxGraphModel.setGrid("1");
        mxGraphModel.setGridSize("10");
        mxGraphModel.setGuides("1");
        mxGraphModel.setTooltips("1");
        mxGraphModel.setConnect("1");
        mxGraphModel.setArrows("1");
        mxGraphModel.setFold("1");
        mxGraphModel.setPage("1");
        mxGraphModel.setPageScale("1");
        mxGraphModel.setPageWidth("827");
        mxGraphModel.setPageHeight("1169");
        mxGraphModel.setMath("0");
        mxGraphModel.setShadow("0");
        return mxGraphModel;
    }

}
