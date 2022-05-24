package pr_pip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class RightPanelTest {
    @InjectMocks
    pr_pip.RightPanel rightPanel;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRightPanelInit() throws Exception {
        rightPanel.rightPanelInit(new pr_pip.MainFrame());
    }

    @Test
    public void testSetStartPoint() throws Exception {
        rightPanel.setStartPoint(0, 0);
    }

    @Test
    public void testSetEndPoint() throws Exception {
        rightPanel.setEndPoint(0, 0);
    }

    @Test
    public void testDrawPerfectRect() throws Exception {
        rightPanel.drawPerfectRect(null, 0, 0, 0, 0);
    }

    @Test
    public void testGetUserChoice() throws Exception {
        rightPanel.getUserChoice(new pr_pip.DrawButton(new java.lang.String[]{"s"}));
    }

    @Test
    public void testPaintComponent() throws Exception {
        rightPanel.paintComponent(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme