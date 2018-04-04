package ru.surfstudio.standard.ui.screen.widget.frame

import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.android.mvpwidget.sample.interactor.ui.base.configurator.WidgetScreenConfigurator
import ru.surfstudio.android.mvpwidget.sample.interactor.ui.base.dagger.activity.ActivityComponent
import ru.surfstudio.android.mvpwidget.sample.interactor.ui.screen.main.widget.frame.FrameWidgetView
import ru.surfstudio.android.mvpwidget.sample.interactor.ui.base.dagger.widget.WidgetScreenModule

/**
 * Простой пример конфигуратора для виджета
 * */
class FrameViewConfigurator : WidgetScreenConfigurator() {

    override fun createScreenComponent(parentComponent: ActivityComponent,
                                       widgetScreenModule: WidgetScreenModule) =
            DaggerFrameViewConfigurator_FrameViewComponent.builder()
                    .activityComponent(parentComponent)
                    .widgetScreenModule(widgetScreenModule)
                    .build()


    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [WidgetScreenModule::class])
    interface FrameViewComponent : ScreenComponent<FrameWidgetView>
}