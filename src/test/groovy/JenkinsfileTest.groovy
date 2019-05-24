import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

import static com.lesfurets.jenkins.unit.MethodCall.callArgsToString
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

/**
 *
 */
class JenkinsfileTest extends BasePipelineTest {

    final String scriptPath = 'Jenkinsfile'

    @Override
    @Before
    void setUp() {
        super.setUp()
        binding.setVariable('scm', null)
        binding.setVariable('env', ['BRANCH_NAME' : 'master'])
    }

    @Test
    void run_happy_pipeline() {
        runScript(scriptPath)
        printCallStack()
    }

    @Test
    void check_if_call_stack_correct() {
        runScript(scriptPath)
        assertTrue(helper.callStack.findAll {
            call -> call.methodName == 'sh'
        }.any {
            callArgsToString(it).contains('build')
        })
    }

    @Test
    void check_if_build_fail() {
        helper.registerAllowedMethod('sh', [String.class], {
            cmd ->
                if(cmd.contains('gradle build')) {
                    binding.getVariable('currentBuild').result = 'FAILURE'
                }
        })
        runScript(scriptPath)
        assertJobStatusFailure()
    }

    @Test
    void check_printInfo_output() {
        def script = loadScript(scriptPath)
        assertTrue(script.printInfo().contains('master'))
        binding.setVariable('env', ['BRANCH_NAME' : 'test'])
        assertTrue(script.printInfo().contains('test'))
    }
}
