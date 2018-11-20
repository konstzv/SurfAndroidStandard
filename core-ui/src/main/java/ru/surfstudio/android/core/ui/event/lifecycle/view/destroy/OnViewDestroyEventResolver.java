/*
  Copyright (c) 2018-present, SurfStudio LLC, Maxim Tuev.

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
package ru.surfstudio.android.core.ui.event.lifecycle.view.destroy;


import java.util.List;

import ru.surfstudio.android.core.ui.ScreenType;
import ru.surfstudio.android.core.ui.event.base.resolver.MultipleScreenEventResolver;
import ru.surfstudio.android.core.ui.event.base.resolver.ScreenEventResolver;

/**
 * см {@link ScreenEventResolver}
 */
public class OnViewDestroyEventResolver extends MultipleScreenEventResolver<OnViewDestroyEvent, OnViewDestroyDelegate, Void> {
    @Override
    public Class<OnViewDestroyDelegate> getDelegateType() {
        return OnViewDestroyDelegate.class;
    }

    @Override
    public Class<OnViewDestroyEvent> getEventType() {
        return OnViewDestroyEvent.class;
    }

    @Override
    public List<ScreenType> getEventEmitterScreenTypes() {
        return ALL_TYPES;
    }

    @Override
    protected Void resolve(OnViewDestroyDelegate delegate, OnViewDestroyEvent event) {
        delegate.onViewDestroy();
        return null;
    }
}
