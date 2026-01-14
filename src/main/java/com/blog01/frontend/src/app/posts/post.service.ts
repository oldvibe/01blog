import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class PostService {

  api = 'http://localhost:8080/api/posts';

  constructor(private http: HttpClient) {}

  getFeed(page = 0) {
    return this.http.get<any>(`${this.api}?page=${page}`);
  }

  create(content: string) {
    return this.http.post(this.api, content);
  }

  like(id: number) {
    return this.http.post(`${this.api}/${id}/like`, {});
  }
}
