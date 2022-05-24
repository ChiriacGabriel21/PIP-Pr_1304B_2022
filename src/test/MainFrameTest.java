package pr_pip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class MainFrameTest {

    @InjectMocks
    pr_pip.MainFrame mainFrame;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFrame() throws Exception {
        javax.swing.JFrame result = mainFrame.getFrame();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFrmInit() throws Exception {
        mainFrame.frmInit();
    }

    @Test
    public void testFrameResize() throws Exception {
        mainFrame.frameResize(new pr_pip.RightPanel(), new pr_pip.DesktopPaneLeft());
    }
}
