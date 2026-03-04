import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenLibro',
  standalone: false,
})
export class ImagenLibroPipe implements PipeTransform {

  transform(pages: number): string {
    if (pages < 150) {
      return 'https://cdn-icons-png.flaticon.com/512/1945/1945940.png';
    }
    if (pages < 250) {
      return 'https://cdn-icons-png.flaticon.com/512/8832/8832880.png';
    }
    if (pages < 400) {
      return 'https://cdn-icons-png.flaticon.com/512/3145/3145765.png';
    }
    return 'https://cdn-icons-png.flaticon.com/512/2232/2232688.png';
  }
}
