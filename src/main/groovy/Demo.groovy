/**
 *
 */
class Demo {
    def one
    def two
    def three

    Demo(one, two, three) {
        this.one = one
        this.two = two
        this.three = three
    }

    def getOne() {
        return one
    }

    def getTwo() {
        return two
    }

    def getThree() {
        return three
    }

    def summ() {
        return one + two + three
    }

    def print() {
        println "Kalle Anka"
    }
}
