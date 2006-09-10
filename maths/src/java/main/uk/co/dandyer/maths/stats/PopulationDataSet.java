// ============================================================================
//   Copyright 2006 Daniel W. Dyer
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// ============================================================================
package uk.co.dandyer.maths.stats;

/**
 * Utility class for calculating statistical measures for data
 * sets that represent a finite population.
 * @author Daniel Dyer
 */
public final class PopulationDataSet extends AbstractDataSet
{
    public PopulationDataSet()
    {
        super();
    }


    public PopulationDataSet(double[] dataSet)
    {
        super(dataSet);
    }


    public double getVariance()
    {
        double mean = getArithmeticMean();
        double squaredDiffs = 0;
        for (int i = 0; i < getSize(); i++)
        {
            double diff = mean - getValue(i);
            squaredDiffs += (diff * diff);
        }
        return squaredDiffs / getSize();
    }
}
