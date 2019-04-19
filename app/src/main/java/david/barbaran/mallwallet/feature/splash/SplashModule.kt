package david.barbaran.mallwallet.feature.splash

import david.barbaran.domain.interactor.CheckVersionUseCase
import david.barbaran.domain.repository.CheckVersionRepository
import david.barbaran.data.repository.CheckVersionDataRepository
import org.koin.dsl.module.module

val splashModule = module {
    single<CheckVersionRepository> { CheckVersionDataRepository() }
    factory { CheckVersionUseCase(get()) }
    factory<SplashController.Presenter> { (controller: SplashController.View) ->
        SplashPresenter(controller, get())
    }
}