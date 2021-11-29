import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";



@Component({
    selector: 'sf-app-settings',
    templateUrl: './sf-app-settings.component.html',
    styleUrls: ['./sf-app-settings.component.scss']
})

export class SfAppSettingsComponent {

    settingsForm: FormGroup

    constructor(private formBuilder: FormBuilder) {
        this.settingsForm = this.formBuilder.group({
            notificationReminder: ["", Validators.required]
        })
    }

}