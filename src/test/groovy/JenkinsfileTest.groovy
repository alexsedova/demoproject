import com.swedbank.jenkins.utilities.PipelineTestRunner
import spock.lang.Specification

/**
 *
 */
class JenkinsfileTest extends Specification {
    PipelineTestRunner runner

    def setup() {
        runner = new PipelineTestRunner()
        runner.preferClassLoading = false
    }

    def "Load bloody Jenkinsfile"() {
        when:
        def testResult = runner.load {
            script 'Jenkinsfile'
            property 'any', { null }
            method('mockedMethod', [String]) { str -> return "Hello, ${str}" }
        }
        println "CALL:" + runner.helper.callStack
        then:
        assert testResult.mockedMethod('bla') == "Hello, bla"
    }

}
