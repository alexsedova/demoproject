import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

/**
 *
 */
class JenkinsfileTest extends BasePipelineTest {
    def script
    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        def scmBranch = "feature_test"
        script = loadScript('Jenkinsfile')
        //helper.registerAllowedMethod("sh", [Map.class], {c -> 'bcc19744'})
        binding.setVariable('env', ['BRANCH_NAME':'master'])
        binding.setVariable('scm', [
                $class                           : 'GitSCM',
                branches                         : [[name: scmBranch]]
        ])
    }

    @Test
    void should_execute_without_errors() throws Exception {
        //def script = loadScript("Jenkinsfile")
        script.execute()
        printCallStack()
    }

    @Test
    void  try_not_master_branch() throws Exception {
        binding.setVariable('env', ['BRANCH_NAME' : 'test'])
        script.execute()
        printCallStack()
    }
}
