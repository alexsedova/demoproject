import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

import static com.lesfurets.jenkins.unit.MethodCall.callArgsToString
import static org.junit.Assert.assertTrue

/**
 *
 */
class JenkinsfileTest extends BasePipelineTest {
    final String scriptParth = 'Jenkinsfile'

    @Override
    @Before
    void setUp() {
        super.setUp()
    }

    @Test
    void run_happy_pipeline() {
        runScript(scriptParth)
        printCallStack()
    }
}
