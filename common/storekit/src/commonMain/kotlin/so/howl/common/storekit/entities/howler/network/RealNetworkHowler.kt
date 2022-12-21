package so.howl.common.storekit.entities.howler.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import so.howl.common.storekit.entities.howler.HowlerId
import so.howl.common.storekit.entities.user.HowlUserId

@Serializable
data class RealNetworkHowler(
    @SerialName("_id")
    override val id: HowlerId,
    override val name: String,
    override val avatarUrl: String,
    override val ownerIds: List<HowlUserId>,
) : NetworkHowler