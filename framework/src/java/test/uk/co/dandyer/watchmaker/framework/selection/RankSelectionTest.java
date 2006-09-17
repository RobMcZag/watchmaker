package uk.co.dandyer.watchmaker.framework.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import uk.co.dandyer.maths.random.MersenneTwisterRNG;
import uk.co.dandyer.watchmaker.framework.EvaluatedCandidate;
import uk.co.dandyer.watchmaker.framework.SelectionStrategy;

/**
 * Unit test for rank-proportionate selection.
 * @author Daniel Dyer
 */
public class RankSelectionTest
{
    /**
     * Test selection when scores are normalised (higher is better).
     */
    @Test
    public void testNormalisedSelection()
    {
        SelectionStrategy selector = new RankSelection();
        List<EvaluatedCandidate<String>> population = new ArrayList<EvaluatedCandidate<String>>(4);
        // Higher score is better.
        EvaluatedCandidate<String> steve = new EvaluatedCandidate<String>("Steve", 10.0);
        EvaluatedCandidate<String> john = new EvaluatedCandidate<String>("John", 4.5);
        EvaluatedCandidate<String> mary = new EvaluatedCandidate<String>("Mary", 1.0);
        EvaluatedCandidate<String> gary = new EvaluatedCandidate<String>("Gary", 0.5);
        population.add(steve);
        population.add(john);
        population.add(mary);
        population.add(gary);
        List<String> selection = selector.select(population, 4, new MersenneTwisterRNG());
        assert selection.size() == 4 : "Selection size is " + selection.size() + ", should be 4.";
        int steveCount = Collections.frequency(selection, steve.getCandidate());
        int johnCount = Collections.frequency(selection, john.getCandidate());
        int garyCount = Collections.frequency(selection, gary.getCandidate());
        int maryCount = Collections.frequency(selection, mary.getCandidate());
        assert steveCount >= 1 && steveCount <= 2 : "Candidate selected wrong number of times (should be 1 or 2, was " + steveCount + ")";
        assert johnCount >= 1 && johnCount <= 2 : "Candidate selected wrong number of times (should be 1 or 2, was " + johnCount + ")";
        assert garyCount <= 1 : "Candidate selected wrong number of times (should be 0 or 1, was " + garyCount + ")";
        assert maryCount <= 1 : "Candidate selected wrong number of times (should be 0 or 1, was " + maryCount + ")";
    }


    /**
     * Test selection when scores are de-normalised (lower is better).
     */
    @Test
    public void testDenormalisedSelection()
    {
        SelectionStrategy selector = new RankSelection();
        List<EvaluatedCandidate<String>> population = new ArrayList<EvaluatedCandidate<String>>(4);
        // Lower score is better.
        EvaluatedCandidate<String> gary = new EvaluatedCandidate<String>("Gary", 0.5);
        EvaluatedCandidate<String> mary = new EvaluatedCandidate<String>("Mary", 1.0);
        EvaluatedCandidate<String> john = new EvaluatedCandidate<String>("John", 4.5);
        EvaluatedCandidate<String> steve = new EvaluatedCandidate<String>("Steve", 10.0);
        population.add(gary);
        population.add(mary);
        population.add(john);
        population.add(steve);
        List<String> selection = selector.select(population, 4, new MersenneTwisterRNG());
        assert selection.size() == 4 : "Selection size is " + selection.size() + ", should be 4.";
        int garyCount = Collections.frequency(selection, gary.getCandidate());
        int maryCount = Collections.frequency(selection, mary.getCandidate());
        int johnCount = Collections.frequency(selection, john.getCandidate());
        int steveCount = Collections.frequency(selection, steve.getCandidate());
        assert garyCount >= 1 && garyCount <= 2 : "Candidate selected wrong number of times (should be 1 or 2, was " + garyCount + ")";
        assert maryCount >= 1 && maryCount <= 2 : "Candidate selected wrong number of times (should be 1 or 2, was " + maryCount + ")";
        assert johnCount <= 1 : "Candidate selected wrong number of times (should be 0 or 1, was " + johnCount + ")";
        assert steveCount <= 1 : "Candidate selected wrong number of times (should be 0 or 1, was " + steveCount + ")";
    }
}