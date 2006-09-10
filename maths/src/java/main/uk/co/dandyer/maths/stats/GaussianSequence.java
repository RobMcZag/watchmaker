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

import java.util.Random;
import uk.co.dandyer.maths.NumberSequence;

/**
 * Random sequence with values drawn from a continuous normal distribution.
 * @author Daniel Dyer
 */
public class GaussianSequence implements NumberSequence<Double>
{
    private final Random generator;
    private final double mean;
    private final double standardDeviation;


    public GaussianSequence(double mean,
                            double standardDeviation,
                            Random generator)
    {
        this.generator = generator;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }


    public Double nextValue()
    {
        return generator.nextGaussian() * standardDeviation + mean;
    }
}
