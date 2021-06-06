import {Inventory} from "./inventory";

export class Project {
  constructor(
    public projectId: number,
    public description: string,
    public inventory: Inventory
  ) {}
}
