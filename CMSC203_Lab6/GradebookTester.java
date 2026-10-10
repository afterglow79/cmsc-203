import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTester {
    GradeBook gradebook;
    GradeBook gradebook2;

    @BeforeEach
    void setUp() {

        gradebook = new GradeBook(5);
        gradebook2 = new GradeBook(5);

        gradebook.addScore(85.0);
        gradebook.addScore(92.0);

        gradebook2.addScore(74.0);
        gradebook2.addScore(88.0);
        gradebook2.addScore(95.0);
    }

    @Test
    void addScore() {
        assertTrue(gradebook.toString().equals("85.0 92.0 "));
        assertTrue(gradebook2.toString().equals("74.0 88.0 95.0 "));

        assertEquals(2, gradebook.getScoreSize());
        assertEquals(3, gradebook2.getScoreSize());
    }

    @Test
    void sum() {
        assertEquals(177.0, gradebook.sum(), 0.001);
        assertEquals(257.0, gradebook2.sum(), 0.001);
    }

    @Test
    void minimum() {
        assertEquals(85.0, gradebook.minimum(), 0.001);
        assertEquals(74.0, gradebook2.minimum(), 0.001);
    }

    @Test
    void finalScore() {
        assertEquals(92.0, gradebook.finalScore(), 0.001);
        assertEquals(183.0, gradebook2.finalScore(), 0.001);
    }

    @AfterEach
    public void tearDown() {
        gradebook = null;
        gradebook2 = null;
    }
}