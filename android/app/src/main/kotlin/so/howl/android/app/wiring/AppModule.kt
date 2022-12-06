package so.howl.android.app.wiring

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import org.mobilenativefoundation.store.store5.Market
import so.howl.android.common.scoping.AppScope
import so.howl.android.common.scoping.SingleIn
import so.howl.common.api.HowlApi
import so.howl.common.api.HowlUserApi
import so.howl.common.api.HowlerApi
import so.howl.common.api.HttpClient
import so.howl.common.api.RealHowlApi
import so.howl.common.store.howl_user.HowlUserMarketInput
import so.howl.common.store.howl_user.HowlUserMarketKey
import so.howl.common.store.howl_user.HowlUserMarketOutput
import so.howl.common.store.howl_user.HowlUserMarketProvider
import so.howl.common.store.howler.HowlerMarketInput
import so.howl.common.store.howler.HowlerMarketKey
import so.howl.common.store.howler.HowlerMarketOutput
import so.howl.common.store.howler.HowlerMarketProvider
import javax.inject.Named

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @Provides
    fun provideHowlApi(): HowlApi = RealHowlApi(HttpClient)

    @Provides
    fun provideHowlUserApi(): HowlUserApi = RealHowlApi(HttpClient)

    @Provides
    fun provideHowlerApi(): HowlerApi = RealHowlApi(HttpClient)

    @SingleIn(AppScope::class)
    @Named(HOWL_USER_MARKET)
    @Provides
    fun provideHowlUserMarket(api: HowlUserApi): Market<HowlUserMarketKey, HowlUserMarketInput, HowlUserMarketOutput> = HowlUserMarketProvider(api).provide()

    @SingleIn(AppScope::class)
    @Named(HOWLER_MARKET)
    @Provides
    fun provideHowlerMarket(api: HowlerApi): Market<HowlerMarketKey, HowlerMarketInput, HowlerMarketOutput> = HowlerMarketProvider(api).provide()

    const val HOWL_USER_MARKET = "HOWL_USER_MARKET"
    const val HOWLER_MARKET = "HOWLER_MARKET"
}
