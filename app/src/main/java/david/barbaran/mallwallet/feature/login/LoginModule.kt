package david.barbaran.mallwallet.feature.login

import org.koin.dsl.module.module

val loginModule = module {
    factory { (controller: LoginController.View) -> LoginPresenter(controller) }
}