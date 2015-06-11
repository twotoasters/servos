/*
 * Copyright (C) 2015 Two Toasters
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
package com.ticketmaster.servos.util.otto;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with
 * a more efficient means such as through injection directly into interested classes.
 */
public final class BusProvider {

    private static final MainPostingBus BUS = new MainPostingBus();

    private BusProvider() {
        // no op
    }

    public static MainPostingBus getInstance() {
        return BUS;
    }

    public static void register(Object... objects) {
        for (Object obj : objects) {
            BUS.register(obj);
        }
    }

    public static void unregister(Object... objects) {
        for (Object obj : objects) {
            BUS.unregister(obj);
        }
    }

    public static void post(Object event) {
        BUS.post(event);
    }
}