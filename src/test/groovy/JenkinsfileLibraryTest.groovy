import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.global.lib.LocalSource

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library

import org.junit.Before
import org.junit.Test

/**
 *
 */
class JenkinsfileLibraryTest extends BasePipelineTest {
    final String scriptPath = 'JenkinsfileLibrary'
    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        helper.registerAllowedMethod("sh", [Map.class], {c -> 'bcc19744'})
        binding.setVariable('env', ['BRANCH_NAME':'master'])
        binding.setVariable('scm', null)
    }

    @Test
    void check_if_method_loaded() {
        String clonePath = 'out/library'
        def library = library()
                .name('common-library')
                .retriever(new LocalSource('out/'))
                .targetPath(clonePath)
                .defaultVersion("master")
                .allowOverride(true)
                .implicit(false)
                .build()

        helper.registerSharedLibrary(library)

        runScript(scriptPath)
        printCallStack()
    }
}
