import org.junit.Assert;
import org.junit.Test;

public class InfixEvaluatorTest {

    @Test
    public void testExpression01() {
        Assert.assertEquals(1, InfixEvaluator.evaluate("7 - 3 * 2"));
    }

    @Test
    public void testExpression02() {
        Assert.assertEquals(8, InfixEvaluator.evaluate("( 7 - 3 ) * 2"));
    }

    @Test
    public void testExpression03() {
        Assert.assertEquals(18, InfixEvaluator.evaluate("2 * 3 ^ 2"));
    }

     @Test
    public void testExpression04() {
        Assert.assertEquals(11, InfixEvaluator.evaluate("( 4 + 3 ) * 2 - 3"));
    }

    @Test
    public void testExpression05() {
        Assert.assertEquals(17, InfixEvaluator.evaluate("5 + 3 * ( 6 - 2 )"));
    }

    @Test
    public void testExpression06() {
        Assert.assertEquals(8, InfixEvaluator.evaluate("2 ^ 3"));
    }

    @Test
    public void testExpression07() {
        Assert.assertEquals(64, InfixEvaluator.evaluate("( 2 ^ 3 ) ^ 2"));
    }

    @Test
    public void testExpression08() {
        Assert.assertEquals(10, InfixEvaluator.evaluate("(( 4 * 2 ) + 6 ) / 2"));
    }

    @Test
    public void testExpression09() {
        Assert.assertEquals(9, InfixEvaluator.evaluate("(( 4 * 2 ) + 6 ) / ( 2 + 1 )"));
    }

    @Test
    public void testExpression10() {
        Assert.assertEquals(6, InfixEvaluator.evaluate("( ( 1 + 2 ) * ( 4 - 1 ) ) / 3"));
    }

}
