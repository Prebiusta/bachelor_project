import { Injectable } from '@angular/core';
import { HttpRequestService } from '../../core/services/http-request.service';
import { SfRole } from '../../core/models/sf-role';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RoleService {

  constructor(private http: HttpRequestService) {
  }

  public getForUser(userId: string): Observable<SfRole[]> {
    const request = { userId: userId };

    return this.http.postType<SfRole[]>("api/role/getForUser", request);
  }

  public getAvailableRoles(): Observable<SfRole[]> {
    return this.http.postType<SfRole[]>("api/role/getAll", {});
  }

  public assignRole(userId: string, roleKey: string): Observable<Object> {
    const request = { userId: userId, role: roleKey };

    return this.http.post("api/role/assign", request);
  }

  public revokeRole(userId: string, roleKey: string): Observable<Object> {
    const request = { userId: userId, role: roleKey };

    return this.http.post("api/role/revoke", request);
  }

}