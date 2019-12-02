import org.junit.Before
import org.junit.Test

/**
 *
 */
//class JenkinsfileMethodTest extends BasePipelineTest {
//
//    final String scriptPath = 'JenkinsfileMethod'
//
//    @Override
//    @Before
//    void setUp() throws Exception {
//        super.setUp()
//        def scmBranch = "feature_test"
//        binding.setVariable('env', ['BRANCH_NAME':'master'])
//        binding.setVariable('scm', null)
//    }
//
//    @Test
//    void should_execute_without_errors() throws Exception {
//        runScript(scriptPath)
//        printCallStack()
//    }
//
//    @Test
//    void  try_not_master_branch() throws Exception {
//        binding.setVariable('env', ['BRANCH_NAME' : 'test'])
//        def script = loadScript(scriptPath)
//        assert script.printInfo() == "I'm going to build on test"
//        printCallStack()
//    }
//}
