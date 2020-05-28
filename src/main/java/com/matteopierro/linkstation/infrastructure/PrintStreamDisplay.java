package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.Display;
import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;

import java.io.PrintStream;

public class PrintStreamDisplay implements Display {

    private final PrintStream printStream;

    public static Display consoleDisplay() {
        return new PrintStreamDisplay(System.out);
    }

    protected PrintStreamDisplay(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void noLinkStationFor(Device device) {
        printStream.println("No link station within reach for point "+ device.point());
        printStream.flush();
    }

    @Override
    public void linkStationFor(Device device, LinkStation station) {
        throw new UnsupportedOperationException();
    }
}
