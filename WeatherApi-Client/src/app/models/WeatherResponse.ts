
export class WeatherResponse {

    forecast: any;

    constructor(forecast: forecast) {
        this.forecast = forecast;

    }
}

class forecast {
    
    forecastday: forecastday;

    constructor(forecastday : forecastday) {
        this.forecastday = forecastday
    }
    
}

class forecastday{
    date : string
    day : day
    constructor(date : string,day : day){
        this.date = date
        this.day = day
    }
}

class day{
    avgtemp_c : number
    condition : condition
    maxtemp_c : number
    mintemp_c : number

    constructor(avgtemp_c : number,
        condition : condition,
        maxtemp_c : number,
        mintemp_c : number){
            this.avgtemp_c = avgtemp_c
            this.condition = condition
            this.maxtemp_c = maxtemp_c
            this.mintemp_c = mintemp_c
        }
}

class condition{
    text : string
    constructor(text : string){
        this.text = text
    }
}
