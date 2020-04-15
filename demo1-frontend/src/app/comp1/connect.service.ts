import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient} from '@angular/common/http';
import { map } from 'rxjs/operators';
const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable(
    {
        providedIn:'root'
    }
)
export class connectService{
    output: String[];
    constructor(private http: HttpClient) {
        
    }

    getStringList(inp: String){
        return this.http.get("http://localhost:8080/getCombination?input=" + inp);
    }
}