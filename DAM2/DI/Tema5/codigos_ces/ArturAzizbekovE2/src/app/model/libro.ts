import { Villain } from "./villain";

export interface Libro {
id: number;
Year: number;
Title: string;
Pages: number;
villains: Villain[];
}