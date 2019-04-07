package david.barbaran.mallwallet.feature.splash

import org.koin.dsl.module.module

val splashModule = module {
    factory { (controller: SplashController.View) -> SplashPresenter(controller) }
}