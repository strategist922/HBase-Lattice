/*
 * 
 *  Copyright © 2010, 2011 Inadco, Inc. All rights reserved.
 *  
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *  
 *         http://www.apache.org/licenses/LICENSE-2.0
 *  
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *  
 *  
 */
package com.inadco.hbl.client.impl.functions;

import java.io.IOException;

import org.apache.hadoop.io.DataInputBuffer;

import com.inadco.hbl.client.impl.SliceOperation;
import com.inadco.hbl.protocodegen.Cells.Aggregation;
import com.inadco.hbl.protocodegen.Cells.Aggregation.Builder;
import com.inadco.math.aggregators.OnlineCannyBiasedBinomialSummarizer;

public class FCannyBiasedBinSum extends FCustomStateFunc {

    private double dt;

    FCannyBiasedBinSum(String name, int ordinal, double dt) {
        super(name, ordinal);
        this.dt = dt;
    }

    @Override
    public void apply(Builder result, Object measureFact) {
        // TODO Auto-generated method stub

    }

    @Override
    public void merge(Builder accumulator, Aggregation source, SliceOperation operation) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean supportsComplementScan() {
        return true;
    }

    @Override
    public Object getAggrValue(Aggregation source) {
        try {
            return extractState(source, new OnlineCannyBiasedBinomialSummarizer());

        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }

    }

}