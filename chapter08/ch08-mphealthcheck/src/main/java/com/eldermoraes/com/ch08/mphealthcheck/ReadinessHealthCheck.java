/*
 * Copyright 2020 Oracle Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eldermoraes.com.ch08.mphealthcheck;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author eldmorae
 */
@Readiness
@ApplicationScoped
public class ReadinessHealthCheck implements HealthCheck {
    
    @Override
    public HealthCheckResponse call() {
        if (isAcessible()){
            return HealthCheckResponse.up("I'm live and ready!");
        } else{
            return HealthCheckResponse.down("I'm live, but not ready...");
        }
    }
    
    private boolean isAcessible(){
        Random random = new Random();
        return random.nextBoolean();
    }
    
}