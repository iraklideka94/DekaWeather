package com.example.dekaweather.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dekaweather.domains.model.WeatherResult
import com.example.dekaweather.utils.Constants
import com.example.dekaweather.utils.Utils.Companion.buildingIconUrl
import com.example.dekaweather.utils.Utils.Companion.timeStampToHumanDate
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIconType
import com.guru.fontawesomecomposelib.FaIcons




@Composable
fun WeatherSection(weatherResponse: WeatherResult) {

    //title section
    var title = ""
    if (!weatherResponse.name.isNullOrEmpty()) {
        weatherResponse.name?.let {
            title = it
        }
    } else {
        weatherResponse.coord?.let {
            title = "Lat: ${it.lat} / Lng: ${it.lon}"
        }
    }

    // subtitle section
    var subTitle = ""
    val dataVal = (weatherResponse.dt ?: 0)
    subTitle = if (dataVal == 0) Constants.LOADING
    else timeStampToHumanDate(dataVal.toLong(), "dd/MM/yyyy")

    //temp section
    var temp = ""
    weatherResponse.main?.let {
        temp = "${it.temp}°C"
    }

    //wind section
    var wind = ""
    weatherResponse.wind?.let {
        wind = if (it ==null) Constants.LOADING else "${it.speed} "
    }

    //clouds section
    var clouds = ""
    weatherResponse.clouds?.let {
        clouds = if (it ==null) Constants.LOADING else "${it.all} "
    }

    //snow section
    var snow = ""
    weatherResponse.snow?.let {
        snow = if (it!!.d1h ==null) Constants.NA else "${it.d1h} "
    }

    //icon section
    var icon = ""
    var description = ""
    weatherResponse.weather.let {
        if (it!!.size > 0) {
            description = if (it[0].description == null) Constants.LOADING else it[0].description!!
            icon = it[0].icon!!
        }
    }


    WeatherTitleSection(text = title, subText = subTitle, fontSize = 38.sp)
    WeatherImage(icon = icon)
    WeatherTitleSection(text = temp, subText = description, fontSize = 38.sp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherInfo(icon = FaIcons.Wind, text = wind)
        WeatherInfo(icon = FaIcons.Cloud, text = clouds)
        WeatherInfo(icon = FaIcons.Snowflake, text = snow)
    }
}


@Composable
fun WeatherInfo(icon: FaIconType.SolidIcon, text: String) {
Column {
    FaIcon(faIcon = icon, size = 48.dp, tint = Color.White)
    Text(text = text, fontSize = 24.sp, color = Color.White)
}
}


@Composable
fun WeatherImage(icon: String) {
    AsyncImage(
        model = buildingIconUrl(icon), contentDescription = icon,
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentScale = ContentScale.FillBounds
    )

}

@Composable
fun WeatherTitleSection(text: String, subText: String, fontSize: TextUnit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = fontSize, color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = subText, fontSize = 14.sp, color = Color.White)
    }

}
