import org.junit.Before

/**
 *
 */
class DemoTest extends spock.lang.Specification {
    Demo demoClient
    @Before
    public void setUp() throws Exception {
        demoClient = new Demo(1, 2, 3)
    }

    def "GetOne"() {
        assert demoClient.getOne() == 1
    }

    def "GetTwo"() {
        assert demoClient.getTwo() == 2
    }

    def "GetThree"() {
        assert demoClient.getThree() == 3
    }

    def "Summ"() {
        assert demoClient.summ() == 6
    }
}
