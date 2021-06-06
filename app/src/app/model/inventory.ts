export class Inventory {
  constructor(
    public id: number,
    public dbType: string,
    public dbName: string,
    public hostname: string,
    public port: any,
    public username: string,
    public password: string
  ) {}
}
