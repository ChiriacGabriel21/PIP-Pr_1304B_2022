package pr_pip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class DrawButtonTest {

    @InjectMocks
    pr_pip.DrawButton drawButton;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDrawButtonInit() throws Exception {
        drawButton.drawButtonInit(new pr_pip.DesktopPaneLeft());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme