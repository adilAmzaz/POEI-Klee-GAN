export class GlobalConfig {
    public static serverUrl : string = "http://localhost:8083/"
    public static userEndPoint : string = `${GlobalConfig.serverUrl}user/`
    public static getUsersEndPoint: string = `${GlobalConfig.serverUrl}getusers/`
    public static actualityEndPoint : string = `${GlobalConfig.serverUrl}actuality/`
}
