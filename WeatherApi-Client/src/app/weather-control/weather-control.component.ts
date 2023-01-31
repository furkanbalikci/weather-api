import { Component } from '@angular/core';
import { WeatherResponse } from '../models/WeatherResponse';
import { WeatherService } from '../services/weather.service';

interface Day{
  num: number;
}

const ELEMENT_DATA: WeatherResponse[] = [
];

@Component({
  selector: 'app-weather-control',
  templateUrl: './weather-control.component.html',
  styleUrls: ['./weather-control.component.css']
})
export class WeatherControlComponent {

  // vars
  city: any;
  country: any;
  weatherResult: any;
  selectedNum : any;

  days : Day[] = [
    {num : 1},{num : 2},{num : 3},{num : 4},{num : 5},{num : 6},{num : 7},{num : 8},{num : 9},
    {num : 10},{num : 11},{num : 12},{num : 13},{num : 14}
  ]

  displayedColumns: string[] = ['Date', 'Max Temperature', 'Min Temperature', 'Average Temperature', 'Description'];
  dataSource = ELEMENT_DATA;

  constructor(private _weatherService: WeatherService) {
    
  }

  ngOnInit() {

  }

  ngAfterInit() {

  }

  


  sendData() {
    
    this._weatherService.weatherQuery(this.city).subscribe(response => 
      {        
        this.weatherResult = new WeatherResponse(response.forecast.forecastday);
        console.log(this.weatherResult)
        var weatherList = new Array<WeatherResponse>();
        for (let i = 0; i < this.selectedNum; i++) {
            weatherList.push(this.weatherResult.forecast[i]);
            
        }
        
        this.dataSource = weatherList;
        

        console.log(this.dataSource)
      }
    );
  }

}
