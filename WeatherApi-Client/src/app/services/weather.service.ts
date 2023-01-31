import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WeatherResponse } from '../models/WeatherResponse';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  private serverUrl: string = "http://localhost:8080/weather/"

  constructor(private http: HttpClient) { }

  public weatherQuery(city: string) : Observable<WeatherResponse> {
    const url = this.serverUrl + city;

    return this.http.get<WeatherResponse>(url);
  }
}
