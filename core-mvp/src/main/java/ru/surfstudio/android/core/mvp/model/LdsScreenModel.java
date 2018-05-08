/*
  Copyright (c) 2018-present, SurfStudio LLC.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package ru.surfstudio.android.core.mvp.model;

import ru.surfstudio.android.core.mvp.model.state.LoadState;

/**
 * модель экрана с поддержкой
 * {@link LoadState}
 * <p>
 * работает в связке c BaseLds...View
 * <p>
 * также см {@link ScreenModel}
 */
public class LdsScreenModel extends ScreenModel {
    private LoadState loadState = LoadState.NONE;

    public void setLoadState(LoadState loadState) {
        this.loadState = loadState;
    }

    public LoadState getLoadState() {
        return loadState;
    }
}
