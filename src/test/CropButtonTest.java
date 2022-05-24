package pr_pip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class CropButtonTest {

    @InjectMocks
    pr_pip.CropButton cropButton;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCropButtonInit() throws Exception {
        cropButton.cropButtonInit(new pr_pip.DesktopPaneLeft());
    }

    @Test
    public void testCreateCropButton() throws Exception {
        cropButton.CreateCropButton(new pr_pip.RightPanel());
    }

    @Test
    public void testCropImage() throws Exception {
        cropButton.cropImage(new pr_pip.RightPanel());
    }
}
