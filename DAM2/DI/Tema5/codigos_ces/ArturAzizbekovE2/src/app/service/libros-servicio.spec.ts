import { TestBed } from '@angular/core/testing';

import { LibrosServicio } from './libros-servicio';

describe('LibrosServicio', () => {
  let service: LibrosServicio;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibrosServicio);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
