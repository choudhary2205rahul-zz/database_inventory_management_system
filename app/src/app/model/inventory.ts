export class Inventory {
  constructor(
    public projectId: number,
    public description: string,
    public dbType: string,
    public dbName: string,
    public hostName: string,
    public port: number,
    public password: string
  ) {}
}
