/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.ai.pipeline.services;

import java.util.Map;
import org.apache.skywalking.oap.server.library.module.Service;

import java.util.List;

public interface BaselineQueryService extends Service {
    /**
     * query supported query baseline metrics names
     *
     * @return
     */
    List<String> querySupportedMetrics();

    /**
     * query predicted metrics
     */
    List<PredictServiceMetrics> queryPredictMetrics(List<ServiceMetrics> serviceMetrics,
                                                    long startTimeBucket,
                                                    long endTimeBucket);

    /**
     * query predicted metrics from cache, return all predicted metrics for the given service name and time bucket hour
     */
    Map<String, PredictServiceMetrics.PredictMetricsValue> queryPredictMetricsFromCache(String serviceName, String timeBucketHour);
}
