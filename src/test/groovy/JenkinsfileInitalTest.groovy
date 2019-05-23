import com.lesfurets.jenkins.unit.BasePipelineTest

import static com.lesfurets.jenkins.unit.MethodCall.callArgsToString
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

/**
 *
 */
class JenkinsfileInitalTest extends BasePipelineTest{

    final String script = 'JenkinsfileTwo'
    @Override
    @Before
    public void setUp() {
        super.setUp()
        binding.setVariable('scm', null)
        binding.setVariable('env', ['BRANCH_NAME' : 'master'])
    }

    @Test
    void run_pipeline_succefully() {
        runScript(script)
        printCallStack()
    }

    @Test
    void assert_failure() throws Exception {
        helper.registerAllowedMethod('sh', [String.class], { cmd ->
            if (cmd.contains('build')) {
                binding.getVariable('currentBuild').result = 'FAILURE'
            }
        })
        runScript(script)
        assertJobStatusFailure()
    }

    @Test
    void get_correct_message_based_on_branch_name() {
        runScript(script)
        assertTrue(helper.callStack.findAll {
            it.methodName == 'echo'
        }.any {call -> callArgsToString(call).contains('master')})
    }

    @Test
    void get_correct_message_from_print_function() {
        def scr = loadScript(script)
        assertTrue(scr.printInfo().contains('master'))
        binding.setVariable('env', ['BRANCH_NAME' : 'test'])
        assertTrue(scr.printInfo().contains('test'))
    }

}
