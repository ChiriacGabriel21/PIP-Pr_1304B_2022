package pr_pip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class DesktopPaneLeftTest {
    @InjectMocks
    pr_pip.DesktopPaneLeft desktopPaneLeft;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDesktopPaneLeftInit() throws Exception {
        desktopPaneLeft.desktopPaneLeftInit(new pr_pip.MainFrame());
    }

    @Test
    public void testAddIcons() throws Exception {
        desktopPaneLeft.addIcons();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme