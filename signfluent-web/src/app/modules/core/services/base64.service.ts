import { Injectable } from "@angular/core"

@Injectable({
    providedIn: 'root',
})
export class Base64Service {
    constructor() {}

    public fileToBase64 = (file: File) => new Promise((resolve, reject) => {
        const reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = () => {
            if (reader.result) {
                let encoded = reader.result.toString().replace(/^data:(.*,)?/, '')
                if ((encoded.length % 4) > 0) {
                    encoded += '='.repeat(4 - (encoded.length % 4))
                }
                resolve(encoded)
            }
        }
        reader.onerror = error => reject(error)
    })
}