package pr_pip;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.awt.RequestFocusController;
import sun.java2d.pipe.Region;
import sun.util.logging.PlatformLogger;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.peer.ComponentPeer;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.mockito.Mockito.*;

public class AddButtonTest {
    @InjectMocks
    AddButton addButton;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddButtonInit() throws Exception {
        addButton.addButtonInit(new DesktopPaneLeft());
    }

    @Test
    public void testImageLoad() throws Exception {
        addButton.imageLoad(new RightPanel(), new MainFrame());
    }

    @Test
    public void testLoadImage() throws Exception {
        addButton.loadImage(new RightPanel(), new MainFrame());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme