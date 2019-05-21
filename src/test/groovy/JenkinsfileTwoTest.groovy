import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

/**
 *
 */
class JenkinsfileTwoTest extends BasePipelineTest {
    def script
    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        def scmBranch = "feature_test"
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
        //script.execute()
        runScript('JenkinsfileTwo')
        printCallStack()
    }

    @Test
    void  try_not_master_branch() throws Exception {
        binding.setVariable('env', ['BRANCH_NAME' : 'test'])
        script = loadScript('JenkinsfileTwo')
        assert script.printInfo() == "I'm building test"
        printCallStack()
    }
}
